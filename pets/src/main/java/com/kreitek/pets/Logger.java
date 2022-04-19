
    package com.kreitek.pets;

    public class Logger {
        private static volatile Logger instance = null;
        private int count = 0;

        private Logger() {

            if (instance != null) {

                throw new RuntimeException("Used the getInstance() method to can create.");
            }
        }

        public static Logger getInstance() {

            if (instance == null) {

                synchronized(Logger.class) {

                    if (instance == null) {

                        instance = new Logger();
                    }
                }
            }
            return instance;
        }

        public  void debug(String data){
            System.out.println("[Debug][" + getCount() + " ] " + data);
        }

        public int getCount(){

            count ++;

            return count;
        }
    }



