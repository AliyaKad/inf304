package ru.itis.inf304.Game;

public class Main {

        private Creature[] creatures;

        private void initGame() {
            creatures = new Creature[4];
            creatures[0] = new Something("Something");
            creatures[1] = new Ant("Ant");
            creatures[2] = new Caterpilar("Caterpilar");
            creatures[3] = new Turtle("Turtle");

            for (Creature c: creatures) {
                c.init();
            }
        }
        private void startGame() {
            boolean flag = true;
            while (flag) {
                for (Creature c : creatures) {
                    Point p = c.move();
                    if (inSquare(p)) {
                        c.print();
                        flag = false;
                        break;
                    }
                }
            }
        }

        private boolean inSquare (Point p) {
            return (p.getColumn() >= 400 & p.getColumn() <= 600 & p.getRow() >= 400 & p.getRow() <= 600);
        }
        public static void main(String[] args) {
            Main main = new Main();
            main.initGame();
            main.startGame();
        }
    }