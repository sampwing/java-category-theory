package com.sampwing.categorytheory.challenges;


public class Chapter3 {

    interface Monoid<A> {
        public A identity();
    }

    public class BooleanMonoid implements Monoid<Boolean> {
        private Boolean mBool = false;

        public BooleanMonoid(Boolean bool) {
            mBool = bool;
        }

        public Boolean identity() {
            return mBool;
        }

        public BooleanMonoid and(BooleanMonoid other) {
            return new BooleanMonoid(identity() && other.identity());
        }

        public BooleanMonoid or(BooleanMonoid other) {
            return new BooleanMonoid(identity() || other.identity());
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof BooleanMonoid)) {
                return false;
            }
            return ((BooleanMonoid) o).identity() == identity();
        }


    }

}

