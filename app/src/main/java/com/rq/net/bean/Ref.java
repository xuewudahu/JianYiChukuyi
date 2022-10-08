package com.rq.net.bean;


import java.io.Serializable;

public class Ref {
    private Ref() {
    }

    public static final class BooleanRef implements Serializable {
        public boolean element;

        public BooleanRef() {
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class ByteRef implements Serializable {
        public byte element;

        public ByteRef() {
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class CharRef implements Serializable {
        public char element;

        public CharRef() {
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class DoubleRef implements Serializable {
        public double element;

        public DoubleRef() {
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class FloatRef implements Serializable {
        public float element;

        public FloatRef() {
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class IntRef implements Serializable {
        public int element;

        public IntRef() {
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class LongRef implements Serializable {
        public long element;

        public LongRef() {
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class ObjectRef<T> implements Serializable {
        public T element;

        public ObjectRef() {
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class ShortRef implements Serializable {
        public short element;

        public ShortRef() {
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }
}
