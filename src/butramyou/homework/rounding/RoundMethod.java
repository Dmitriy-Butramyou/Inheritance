package butramyou.homework.rounding;

public enum RoundMethod {
    FLOOR {
        public double roundFunction(double d) {
            return Math.floor(d);
        }
    },
    ROUND {
        public double roundFunction(double d) {
            return Math.round(d);
        }
    },
    CEIL {
        public double roundFunction(double d) {
            return Math.ceil(d);
        }
    };

    public abstract double roundFunction(double value);
}
