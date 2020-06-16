package com.groep6.pfor.util;

import com.groep6.pfor.Config;

public class Matrix4f {
    private float[] values = new float[16];

    /**
     * Create Identity Matrix
     */
    public Matrix4f() {
        setAll(0);
        set(0, 0, 1f);
        set(1, 1, 1f);
        set(2, 2, 1f);
        set(3, 3, 1f);
    }

    public Matrix4f(float... f) {
        setAll(f);
    }

    public Matrix4f(Matrix4f m) {
        for (int i = 0; i < m.values.length; i++) values[i] = m.values[i];
    }

    public static Matrix4f fromPerspective(float fov, float zNear, float zFar) {
        float s = 1f / (float) Math.tan((fov / 2f) *(Math.PI / 180f));
        return new Matrix4f(
            s, 0, 0, 0,
                0, s, 0 ,0,
                0, 0, -(zFar / (zFar - zNear)), -1f,
                0, 0, -((zFar * zNear) / (zFar - zNear)), 0
        );
    }

    public float get(int x, int y) {
        if (x < 0 || x >= 4 || y < 0 || y >= 4) {
            if (Config.DEBUG) System.out.println("[WARNING] Matrix index out of bounds");
            return 0;
        }
        return values[y * 4 + x];
    }

    public Matrix4f set(int x, int y, float value) {
        if (x < 0 || x >= 4 || y < 0 || y >= 4) {
            if (Config.DEBUG) System.out.println("[WARNING] Matrix index out of bounds");
            return this;
        }
        values[y * 4 + x] = value;
        return this;
    }

    public float[] getAll() {
        return values;
    }

    public Matrix4f setAll(float... f) {
        for (int i = 0; i < f.length && i < values.length; i++) {
            values[i] = f[i];
        }
        return this;
    }

    public Matrix4f mul(Matrix4f m) {
        Matrix4f mat = new Matrix4f(
            get(0,0)*m.get(0,0)+get(1,0)*m.get(0,1)+get(2,0)*m.get(0,2)+get(3,0)*m.get(0,3),
                get(0,0)*m.get(1,0)+get(1,0)*m.get(1,1)+get(2,0)*m.get(1,2)+get(3,0)*m.get(1,3),
                get(0,0)*m.get(2,0)+get(1,0)*m.get(2,1)+get(2,0)*m.get(2,2)+get(3,0)*m.get(2,3),
                get(0,0)*m.get(3,0)+get(1,0)*m.get(3,1)+get(2,0)*m.get(3,2)+get(3,0)*m.get(3,3),

                get(0,1)*m.get(0,0)+get(1,1)*m.get(0,1)+get(2,1)*m.get(0,2)+get(3,1)*m.get(0,3),
                get(0,1)*m.get(1,0)+get(1,1)*m.get(1,1)+get(2,1)*m.get(1,2)+get(3,1)*m.get(1,3),
                get(0,1)*m.get(2,0)+get(1,1)*m.get(2,1)+get(2,1)*m.get(2,2)+get(3,1)*m.get(2,3),
                get(0,1)*m.get(3,0)+get(1,1)*m.get(3,1)+get(2,1)*m.get(3,2)+get(3,1)*m.get(3,3),

                get(0,2)*m.get(0,0)+get(1,2)*m.get(0,1)+get(2,2)*m.get(0,2)+get(3,2)*m.get(0,3),
                get(0,2)*m.get(1,0)+get(1,2)*m.get(1,1)+get(2,2)*m.get(1,2)+get(3,2)*m.get(1,3),
                get(0,2)*m.get(2,0)+get(1,2)*m.get(2,1)+get(2,2)*m.get(2,2)+get(3,2)*m.get(2,3),
                get(0,2)*m.get(3,0)+get(1,2)*m.get(3,1)+get(2,2)*m.get(3,2)+get(3,2)*m.get(3,3),

                get(0,3)*m.get(0,0)+get(1,3)*m.get(0,1)+get(2,3)*m.get(0,2)+get(3,3)*m.get(0,3),
                get(0,3)*m.get(1,0)+get(1,3)*m.get(1,1)+get(2,3)*m.get(1,2)+get(3,3)*m.get(1,3),
                get(0,3)*m.get(2,0)+get(1,3)*m.get(2,1)+get(2,3)*m.get(2,2)+get(3,3)*m.get(2,3),
                get(0,3)*m.get(3,0)+get(1,3)*m.get(3,1)+get(2,3)*m.get(3,2)+get(3,3)*m.get(3,3)
        );

        return setAll(mat.getAll());
    }

    public static Matrix4f fromRotationX(float angle) {
        angle = toRadians(angle);
        return new Matrix4f(
            1f, 0, 0, 0,
                0, (float) Math.cos(angle), (float) -Math.sin(angle), 0,
                0, (float) Math.sin(angle), (float) Math.cos(angle), 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4f fromRotationY(float angle) {
        angle = toRadians(angle);
        return new Matrix4f(
                (float) Math.cos(angle), 0, (float) Math.sin(angle), 0,
                0, 1f, 0, 0,
                (float) -Math.sin(angle), 0, (float) Math.cos(angle),
                0, 0, 0, 1f
        );
    }

    public static Matrix4f fromRotationZ(float angle) {
        angle = toRadians(angle);
        return new Matrix4f(
                (float) Math.cos(angle), (float) -Math.sin(angle), 0, 0,
                (float) Math.sin(angle), (float) Math.cos(angle), 0,0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4f fromTranslation(float dx, float dy, float dz) {
        return new Matrix4f(
              1f, 0, 0, dx,
                0, 1f, 0, dy,
                0, 0, 1f, dz,
                0, 0, 0, 1f
        );
    }

    public static Matrix4f fromRotation(float angleX, float angleY, float angleZ) {
        return fromRotationX(angleX).mul(fromRotationY(angleY).mul(fromRotationZ(angleZ)));
    }

    private static float toRadians(float angle) {
        return (float) Math.PI / 180 * angle;
    }
}
