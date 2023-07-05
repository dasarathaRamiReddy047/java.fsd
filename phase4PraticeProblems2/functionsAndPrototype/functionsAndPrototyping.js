// function
function Employee (name, designation, dateOfBirth) {
  this.name = name;
  this.designation = designation;
  this.dateOfBirth = dateOfBirth;
}

//prototype
Employee.prototype.calculateAge = function () {
  let date = new Date (this.dateOfBirth);
  let calculateDate = new Date ();
  console.log (
    `The Current Age is ${calculateDate.getFullYear () - date.getFullYear ()}`
  );
};

console.log (Employee.prototype);

let newEmp1 = new Employee ('Dhoni', 'tester', '1980-11-02');
console.log (newEmp1);
newEmp1.calculateAge ();

let newEmp2 = new Employee ('Sachin', 'devops', '1970-1-1');
console.log (newEmp2);
newEmp2.calculateAge ();

let newEmp3 = new Employee ('Virat', 'devops', '1992-8-2');
console.log (newEmp3);
newEmp3.calculateAge ();
