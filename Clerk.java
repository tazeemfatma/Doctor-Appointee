package Bean;

/**
 * Created by saumya on 14-04-2018.
 */

public class Clerk {
    String id,name,phone,email,address,salary;
    public String toString()
    {
        return id+ " "+" "+name+" "+phone+" "+" "+email+" "+address+" "+salary;
    }

    public Clerk(String id, String name, String phone, String email,String address, String salary) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email=email;
        this.address = address;
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}


