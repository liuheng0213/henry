package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列
 * add pollAll pollDog pollCat isEmpty isDogEmpty  isCatEmpty
 */
public class _04CatAndDogQueue {

    Queue<PetEnterQueue> dogQueue;
    Queue<PetEnterQueue> catQueue;
    long count;

    public _04CatAndDogQueue() {
        this.catQueue = new LinkedList<>();
        this.dogQueue = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet){
        if(pet.getPetType().equals("dog")){
            this.dogQueue.add(new PetEnterQueue(pet,this.count++));
        }else if(pet.getPetType().equals("cat")){
            this.catQueue.add(new PetEnterQueue(pet,this.count++));
        }else{
            throw new RuntimeException("aaaa");
        }
    }

    public Pet pollAll(){
        if(!this.catQueue.isEmpty() && !this.dogQueue.isEmpty()){
            if(this.dogQueue.poll().getCount() < this.catQueue.peek().getCount()){
                return this.dogQueue.poll().getPet();
            }else{
                return this.catQueue.poll().getPet();
            }
        }else if(!this.catQueue.isEmpty()){
            return this.catQueue.poll().getPet();
        }else if(!this.dogQueue.isEmpty()){
            return this.dogQueue.poll().getPet();
        }else{
            throw new RuntimeException("");
        }
    }

    public Dog pollDog(){
        if(!this.dogQueue.isEmpty()){
            return (Dog) this.dogQueue.poll().getPet();
        }else{
            throw new RuntimeException();
        }
    }


    class PetEnterQueue{
        Pet pet;
        long count;


        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }


        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String getEnterPetType(){
            return this.getPet().getPetType();
        }
    }

     class Pet{
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType(){
            return this.type;
        }
    }

     class Dog extends Pet{

         public Dog(String type) {
             super("dog");
         }
     }

    class Cat extends Pet{

        public Cat(String type) {
            super("cat");
        }
    }



}


