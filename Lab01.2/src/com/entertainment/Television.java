package com.entertainment;

import java.util.Objects;

public class Television implements Comparable<Television>{
    private String brand;
    private int volume;

    @Override
    public int compareTo(Television other) {
        return 0;
    }

    private Tuner tuner = new Tuner();

    public Television() {
        super();
    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    /*
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;
        Television that = (Television) obj;

        return this.getVolume() == that.getVolume() && Objects.equals(this.getBrand(), that.getBrand());
    }

     */

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }

    /*
    @Override
    public int hashCode() {
        /*
         * This is a poorly written hash function, because it easily yields "hash collisions".
         * A hash collision is when "different" objects have the same hash code (just by coincident).
         *
        // return getBrand().length() + getVolume();

        // Instead, we rely on Objects.hash() to give us a "scientifically correct" hash function.
        return  Objects.hash(getBrand(), getVolume());
    }
    */


    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        // proceed only if 'obj' is really referencing a Television client
        if (obj != null && this.getClass() == obj.getClass()) {
            // safely downcast 'obj' to more specific reference Television
            Television other = (Television) obj;

            // do the checks; business equality is defined by brand, volume bring the same
            result = Objects.equals(this.getBrand(), other.getBrand()) && // null-safe check
                    this.getVolume() == other.getVolume();        // primitives can't be null
        }

        return result;
    }



    @Override
    public String toString() {
        return getClass().getSimpleName() + " [brand=" + getBrand() + ", volume=" + getVolume() + ", currentChannel=" + getCurrentChannel() + "]";
    }

}