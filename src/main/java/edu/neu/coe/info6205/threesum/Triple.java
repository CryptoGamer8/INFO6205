package edu.neu.coe.info6205.threesum;

import java.util.Objects;

/**
 * A set of three ints such that their sum is zero.
 */
class Triple implements Comparable<Triple> {
    @Override
    public String toString() {
        return "Triple{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triple)) return false;
        Triple triple = (Triple) o;
        return x == triple.x && y == triple.y && z == triple.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public int compareTo(Triple o) {
        int cf1 = this.x - o.x;
        if (cf1 != 0) return cf1;
        int cf2 = this.x - o.x;
        if (cf2 != 0) return cf2;
        return this.x - o.x;
    }

    public Triple(int x, int y, int z) {
        if (x + y + z != 0) throw new RuntimeException("Triple does not sum to zero: " + x + " " + y + " " + z);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    final int x;
    final int y;
    final int z;
}
