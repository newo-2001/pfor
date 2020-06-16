package com.groep6.pfor.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Owen Elderbroek
 */
public class Vector2fTest {
    @Test
    public void testEquals() {
        assertEquals(new Vector2f(3f, 5.5f), new Vector2f(3f, 5.5f));
        assertNotEquals(new Vector2f(2f, -1f), new Vector2f(2f, -1.01f));
    }

    @Test
    public void testConstructors() {
        assertEquals(new Vector2f(), new Vector2f(0, 0));
        assertEquals(new Vector2f(5,3.5f).y, 3.5f, 0.0f);
        assertEquals(new Vector2f(2.31f, 2f).x, 2.31f, 0.0f);
        assertEquals(new Vector2f(new Vector2f(2, 5)), new Vector2f(2, 5));
    }

    @Test
    public void testAddition() {
        assertEquals(new Vector2f(8f, 10.5f), new Vector2f(3f, 5.5f).add(5f));
        assertEquals(new Vector2f(0.3f, 12.2f), new Vector2f(2.5f, 9.1f).add(new Vector2f(-2.2f, 3.1f)));
    }

    @Test
    public void testSubtraction() {
        assertEquals(new Vector2f(1.1f, -3.3f), new Vector2f(3.2f, -1.2f).sub(2.1f));
        assertEquals(new Vector2f(6.785f, -1f), new Vector2f(-1.315f, 0f).sub(new Vector2f(-8.1f, 1f)));
    }

    @Test
    public void testMultiplication() {
        assertEquals(new Vector2f(10.5f, 17.01f), new Vector2f(5f, 8.1f).mul(2.1f));
        assertEquals(new Vector2f(0f, -2.6f), new Vector2f(-3.1f, 2f).mul(new Vector2f(0f, -1.3f)));
    }

    @Test
    public void testDivision() {
        assertEquals(new Vector2f(0.1846f, -0.25f), new Vector2f(1.2f, 1f).div(new Vector2f(6.5f, -4f)));
        assertEquals(new Vector2f(-1.5f, -2.5f), new Vector2f(3f, 5f).div(-2f));
        assertThrows(ArithmeticException.class, () -> new Vector2f(1.5f, 3f).div(new Vector2f(1f, 0f)));
    }

    @Test
    public void testFloor() {
        assertEquals(new Vector2f(2f, -2f), new Vector2f(2.995f, -1.7f).floor());
    }

    @Test
    public void testCeil() {
        assertEquals(new Vector2f(6f, -3f), new Vector2f(5.01f, -3.4f).ceil());
    }

    @Test
    public void testLength() {
        assertEquals(5f, new Vector2f(-3f, -4f).length(), 0f);
    }

    @Test
    public void testAbsolute() {
        assertEquals(new Vector2f(2.4f, 1.3f), new Vector2f(-2.4f, 1.3f).abs());
    }

    @Test
    public void testDistance() {
        assertEquals(5f, new Vector2f(4f, -2f).distance(new Vector2f(7f, 2f)), 0f);
    }

    @Test
    public void testNormalize() {
        assertEquals(new Vector2f(-5f / 13f, 12f / 13f), new Vector2f(-5f, 12f).normalize());
    }

    @Test
    public void testDotProduct() {
        assertEquals(8f, new Vector2f(5, -7).dot(new Vector2f(3, 1)), 0f);
    }

    @Test
    public void testAngle() {
        assertEquals(1.1975, new Vector2f(-1.8f, 3f).angle(new Vector2f(5.4f, 7f)), 0.0001f);
        assertEquals(1.8215, new Vector2f(-5.6f, 2f).angle(new Vector2f(5.4f, 8f)), 0.0001f);
    }
}
