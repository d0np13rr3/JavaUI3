package Game.ClassesCollection;

import Game.Actions;


    public class Werewolf extends Character{
        private int health, attack, magic, mana, dexterity, defense;
        private String name;
        Actions action = new Actions();
        public Werewolf(String name, Actions action){
            health = 100;
            attack = 10;
            magic = 0;
            mana = 0;
            dexterity = 25;
            defense = 10;

            this.name = name;
        }
        public void setHealth(int healthToSet){
            this.health = healthToSet;
        }
        public void setAttack(int attackToSet){
            this.attack = attackToSet;
        }
        public int getAttack(){
            return this.attack;
        }
        public String getName() {return name;}
        public int getHealth() {return health;}
        public int getMagic() {return magic;}
        public int getMana() {return mana;}
        public int getDexterity() {return dexterity;}
        public int getDefense() {return defense;}
}
