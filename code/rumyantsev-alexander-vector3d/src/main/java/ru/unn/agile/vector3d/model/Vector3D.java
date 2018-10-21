package ru.unn.agile.vector3d.model;

import ru.unn.agile.vector3d.model.errorhandling.NullVectorNormalizing;

public class Vector3D {
    public final static double EPSILON = 0.000001;

    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Vector3D) {
            Vector3D otherVector = (Vector3D) obj;

            return Math.abs(x - otherVector.x) < Vector3D.EPSILON &&
                    Math.abs(y - otherVector.y) < Vector3D.EPSILON &&
                    Math.abs(z - otherVector.z) < Vector3D.EPSILON;
        }

        return false;
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(x + other.x, y + other.y, z + other.z);
    }

    public Vector3D subtract(Vector3D other) {
        return new Vector3D(x - other.x, y - other.y, z - other.z);
    }

    public Vector3D multiply(double coef) {
        return new Vector3D(x * coef, y * coef, z * coef);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3D normalize() {
        double mgn = magnitude();

        if (Math.abs(mgn) < Vector3D.EPSILON) {
            throw new NullVectorNormalizing();
        }

        return multiply(1.0 / magnitude());
    }

    public double dot(Vector3D other) {
        return x * other.x + y * other.y + z * other.z;
    }
}
