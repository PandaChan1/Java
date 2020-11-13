package Comarable;

class student implements Comparable<student>{
    String name,sex;
    int age,phone;
    student(String name,String sex,int age,int phone){
        this.name=name;
        this.age=age;
        this.phone=phone;
        this.sex=sex;

    }
    @Override
    public int compareTo(student o) {
        /*if (this.age>o.age) return 1;   //升序
        else if (this.age==o.age) return 0;
        else return -1;*/
//        if (this.age<o.age) return 1; //降序
//        else if (this.age==o.age) return 0;
//        else return -1;
        return o.age - this.age;
    }
    public String toString(){
        return this.name+","+this.age+","+this.sex+","+this.phone;
    }
}
