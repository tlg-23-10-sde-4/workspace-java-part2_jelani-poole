package com.duckrace.client;

import com.duckrace.app.DuckRaceController;

class Main {

    public static void main(String[] args) {
        // instantiate controller and say "GO"
        DuckRaceController app = new DuckRaceController();
        app.execute();
    }
}