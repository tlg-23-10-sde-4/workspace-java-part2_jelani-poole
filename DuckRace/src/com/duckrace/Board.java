package com.duckrace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board implements Serializable {
    private static final String dataFilePath = "data/board.dat";

    /*
     * If data/board.dat exist, read that file into a board object and return it.
     * We will use Java's built-in object serialization feature.
     * Otherwise, return a new Board().
     */
    public static Board getInstance() {
        Board board = null;

        if (Files.exists(Path.of(dataFilePath))) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath))) {
                board = (Board) in.readObject();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            board = new Board();
        }
        return board;
    }

    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    // prevent instantiation from outside, it's only done in here (in getInstance() method)
    private Board() {
    }

    public int maxID() {
        return studentIdMap.size();
    }
    /*
     * Updates the board (racerMap) by making a DuckRacer "win"
     * This could mean fetching an existing DuckRacer from racerMap.
     * or we might need to create a new DuckRacer(id is not in the map), then we need put
     * that new DuckRacer  in the map, and then make it "win".
     */

    public void update(int id, Reward reward) {
        DuckRacer racer = null;

        if (racerMap.containsKey(id)) { // id present, so fetch DuckRacer next to it
            racer = racerMap.get(id);
        }
        else { // id not present, so here we create new DuckRacer
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
        }
        racer.win(reward);
        save();
    }

    /*
     * Writes *this* Board object to binary file data/board.dat
     * Uses built-in Java object serialization facility.
     */
    private void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
            out.writeObject(this);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // shows the "board data" (racerMap) to the end user
    // TODO: render the data so it looks like the board you see everyday
    //
    public void show() {
        Collection<DuckRacer> racers = racerMap.values();

        for (DuckRacer racer : racers) {
            System.out.printf("%s    %s    %s    %s\n",
                    racer.getId(), racer.getName(), racer.getWins(), racer.getRewards());
        }
    }

    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer,String> idMap = new HashMap<>();

        try {
            // read all lines from conf/student-ids.csv into a List<String>
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));

            // for each line, split it into "tokens," i.e., "1,Aaron" is split into "1" and "Aaron"
            for (String line : lines) {
                String[] tokens = line.split(","); // tokens[0] is "1" and tokens[1] is "Aaron"

                // convert tokens as necessary
                idMap.put(Integer.valueOf(tokens[0]), tokens[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return idMap;
    }

}