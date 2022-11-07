public class Player {
    private String name;
    private int score;

    public Player()
    {
        this.name = "No Name";
        this.score = 0;
    }

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player name: " + name + '\n' +
                "Score: " + score;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (this.getClass() == obj.getClass()) {
            Player other = (Player) obj;
            return name.equals(other.getName()) &&
                    score == other.getScore();
        }
        return false;
    }
}