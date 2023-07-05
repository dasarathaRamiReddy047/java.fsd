const empId = (function () {
  let count = 0;
  return function () {
    ++count;
    return `emp${count}`;
  };
}) ();

console.log ('New Emplyee IDs are listed here');
console.log ('Alex: ' + empId ());
console.log ('Dexter: ' + empId ());
console.log ('Annie: ' + empId ());


console.log ('\n');
function fullName (firstName, lastName, callback) {
  console.log ('My name is ' + firstName + ' ' + lastName);
  callback (lastName);
}

var greeting = function (ln) {
  console.log ('Welcome ' + ln);
};

fullName ('Dhoni', 'Ms', greeting);
console.log ('\n');
fullName ('Sachin', 'sharma', greeting);

