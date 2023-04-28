SQL Queries

1.Basic:

1)	Write a query to display the names (first_name, last_name) using alias name “First  Name", "Last Name".
Ans:- SELECT FIRST_NAME as First ,LAST_NAME as Last  FROM employees;

2)  Write a query to get unique department ID from employee table.
Ans:- SELECT distinct(DEPARTMENT_ID)  FROM employees;

3)	Write a query to get the details of all employees according to first name in descending order.
Ans:- SELECT * FROM employees order by FIRST_NAME desc;

4) Write a query to get the employee ID, name (first_name, last_name), salary in ascending order of salary.
Ans:- SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,SALARY FROM employees order by salary;

5) Write a query to get the maximum and minimum salary from employees table.
Ans:- SELECT max(salary),min(salary) FROM employees order by salary;

6) Write a query to get the average salary and number of employees in the employees table.
Ans:- SELECT avg(salary),count(*) FROM employees;

7) Write a query to get the number of employees working with the company.
Ans:- SELECT count(*) FROM employees;

8) Write a query to get the number of designations available in the employees table.
Ans:- select count(distinct(job_id)) from employees;

9) Write a query get all first name from employees table in upper case.
Ans:- SELECT upper(First_name) FROM employees;

10) Write a query to get the first three characters of first name of all employees.
Ans:- SELECT substring(First_name,1,3) FROM employees;

11) Write a query to calculate 171*214+625.
Ans:- SELECT 171*214+625;


2.Restricting and Sorting data:


1)	Write a query to display the name (first_name, last_name) and salary for all employees whose salary is not in the range $10,000 through $15,000 .
Ans:- select first_name,last_name,salary from employees where salary>10000 or salary<15000;

2)	Write a query to display the name (first_name, last_name) and department ID of all employees in departments 30 or 100 in ascending order. 
Ans:- select first_name,last_name,department_id from employees where DEPARTMENT_ID in (30,100) order by department_id;

3)	Write a query to display the name (first_name, last_name) and salary for all employees whose salary is not in the range $10,000 through $15,000 and are in department 30 or 100 .
Ans:- select first_name,last_name,salary from employees where salary > 10000 or salary<15000 and department_id in(30,100);

4)	Write a query to display the name (first_name, last_name) and hire date for all employees who were hired in 1987 .
Ans:- select * from employees where HIRE_DATE like'1987%';

5)	 Write a query to display the first_name of all employees who have both "b" and "c"    in their first name.
Ans:- select FIRST_NAME from employees where FIRST_NAME like'%b%' or FIRST_NAME like'%c%';

6)	Write a query to display the last name, job, and salary for all employees whose job is that of a Programmer or a Shipping Clerk, and salary is not equal to $4,500, $10,000, or $15,000. 
Ans:- select * from employees where JOB_ID in('IT_PROG','SH_CLERK')and SALARY not in(4500,1000,1500);

7)	 Write a query to display the last name of employees whose name have exactly 6 characters.
Ans:- select LAST_NAME from employees where last_name like'______'; OR
select LAST_NAME from employees where length(LAST_NAME)=6;

8)	 Write a query to display the last name of employees having 'e' as the third character. 
Ans:- select LAST_NAME from employees where last_name like'__e%';

9)	 Write a query to display the jobs/designations available in the employees table. 
Ans:- select distinct(job_id) from employees;

10)	 Write a query to display the name (first_name, last_name), salary and PF (15% of salary) of all employees. 
Ans:- select First_name ,last_name,salary,salary*0.15 as PF from employees;
11)	 Write a query to select all record from employees where last name in 'BLAKE', 'SCOTT', 'KING' and 'FORD'.
Ans:- select * from employees where last_name in('BLAKE','SCOTT','KING','FORD');   


3. Aggregate Functions

1)	Write a query to list the number of jobs available in the employees table. 
Ans:- SELECT COUNT(DISTINCT job_id)  FROM employees;

2)	 Write a query to get the total salaries payable to employees.
Ans:- SELECT SUM(salary)  FROM employees;

3)	Write a query to get the minimum salary from employees table. 
Ans:- SELECT min(salary) FROM employees;

4)	 Write a query to get the maximum salary of an employee working as a Programmer.
Ans:- select max(salary) from employees where JOB_ID='IT_PROG';

5)	Write a query to get the average salary and number of employees working the department 90.
Ans:- select avg(salary),count(*) from employees where DEPARTMENT_ID=90;

6)	Write a query to get the highest, lowest, sum, and average salary of all employees. 
Ans:- select max(salary),min(salary),sum(salary),avg(salary) from employees ;

7)	Write a query to get the number of employees with the same job.
Ans:- SELECT job_id, COUNT(*)FROM employees GROUP BY job_id;

8)	Write a query to get the difference between the highest and lowest salaries.
Ans:- SELECT MAX(salary) - MIN(salary) DIFFERENCE FROM employees;

9)	Write a query to find the manager ID and the salary of the lowest-paid employee for that manager.
Ans:- select MANAGER_ID,min(SALARY) from employees group by MANAGER_ID ;

10)	Write a query to get the department ID and the total salary payable in each department. 
Ans:- SELECT department_id, SUM(salary) FROM employees  GROUP BY department_id;

11)	Write a query to get the average salary for each job ID excluding programmer.
Ans:- select avg(salary),job_id from employees where job_id!='IT_PROG' group by job_id;

12)	Write a query to get the total salary, maximum, minimum, average salary of employees.
Ans:- select sum(salary),max(salary),min(salary),avg(salary) from employees

13)	Write a query to get the job ID and maximum salary of the employees where maximum salary is greater than or equal to $4000.
Ans:- SELECT job_id, MAX(salary) FROM employees GROUP BY job_id HAVING  MAX(salary) >=4000;

14)	Write a query to get the average salary for all departments employing more than 10 employees.
Ans:- SELECT department_id, AVG(salary), COUNT(*) FROM employees GROUP BY department_id HAVING COUNT(*) > 10;


4. SubQuery 


1)	Write a query to find the name (first_name, last_name) and the salary of the employees who have a higher salary than the employee whose last_name='Bull'.
Ans:- Select first_name,Last_name,salary from employees where salary> (select salary from employees where LAST_NAME='Bull');

2)	Write a query to find the name (first_name, last_name) of all employees who works in the IT department .
Ans:- select first_name ,last_name from employees where DEPARTMENT_ID in(select DEPARTMENT_ID from departments where DEPARTMENT_NAME like'IT%');

3) Write a query to find the name (first_name, last_name) of the employees who have a manager and worked in a USA based department.
Ans:-Select FIRST_NAME,Last_name from employees where MANAGER_ID!=0 and DEPARTMENT_ID in(select DEPARTMENT_ID from departments where location_id in(select LOCATION_ID from locations where COUNTRY_ID='US'));

4)Write a query to find the name (first_name, last_name) of the employees who are managers.
Ans:- select first_name,last_name from employees where EMPLOYEE_ID in(select MANAGER_ID from employees);

5) Write a query to find the name (first_name, last_name), and salary of the employees	 whose salary is greater than the average salary.
Ans:- select first_name,last_name,salary from employees where salary>(select avg(salary)from employees);

6) Write a query to find the name (first_name, last_name), and salary of the employees whose salary is equal to the minimum salary for their job grade.
Ans:- Select FIRST_NAME,Last_name,Salary from employees where salary=(select MIN_SALARY from jobs where JOB_ID=employees.JOB_ID);

 7) Write a query to find the name (first_name, last_name), and salary of the employees who earns more than the average salary and works in any of the IT departments.
Ans:- select first_name,last_name,salary from employees where salary>(select avg(salary) from employees) and department_id in(select DEPARTMENT_ID from departments where DEPARTMENT_NAME like'IT%');

 8) Write a query to find the name (first_name, last_name), and salary of the employees who earns more than the earning of Mr. Bell.
Ans:- select first_name,last_name,salary from employees where salary>(select salary from employees where last_name like'Bell');

9) Write a query to find the name (first_name, last_name), and salary of the employees who earn the same salary as the minimum salary for all departments.
Ans:- SELECT first_name,LAST_NAME,SALARY FROM employees e1 where salary=(select min(salary) from employees e2 where e2.DEPARTMENT_ID=e1.DEPARTMENT_ID);

10) Write a query to find the name (first_name, last_name) and salary of the employees who earn a salary that is higher than the salary of all the Shipping Clerk (JOB_ID = 'SH_CLERK'). Sort the results of the salary of the lowest to highest.
Ans:- select first_name,last_name,salary from employees where salary>(select max(salary) from employees  where JOB_ID='sh_clerk') order by salary;

 11) Write a query to find the name (first_name, last_name) of the employees who are not Programmer.
Ans:- select FIRST_NAME,last_name,Job_Id from employees where job_id<>'IT_PROG';

12) Write a query to display the employee ID, first name, last name, and department names of all employees.
Ans:- select first_name,last_name,(select DEPARTMENT_NAME from departments where departments.DEPARTMENT_ID=employees.DEPARTMENT_ID ) As Depatment_Name from employees;


13) Write a query to display the employee ID, first name, last name, salary of all employees whose salary is above average for their departments. 
Ans:- select EMPLOYEE_ID,FIRST_NAME,LAST_NAME,SALARY from employees where salary>(select avg(salary) from employees where DEPARTMENT_ID=employees.DEPARTMENT_ID);

14) Write a query to fetch even numbered records from employees table.
Ans:- select EMPLOYEE_ID from employees where EMPLOYEE_ID%2=0;

15) Write a query to find the 5th maximum salary in the employees table.
Ans:- select salary from employees order by salary desc  limit 4,1;

 16) Write a query to find the 4th minimum salary in the employees table.
Ans:- select salary from employees order by salary desc limit 3,1;

 17) Write a query to select last 10 records from a table.
Ans:- select * from(select * from employees order by employee_id desc limit 10)data order by EMPLOYEE_ID;

 18) Write a query to list the department ID and name of all the departments where no employee is working.
Ans:-SELECT DEPARTMENT_ID, DEPARTMENT_NAME FROM departments WHERE department_id  NOT IN (select department_id FROM employees);

 19) Write a query to get 3 maximum salaries.
Ans:- select distinct(salary)from employees order by salary desc limit 3
 
20) Write a query to get 3 minimum salaries.
Ans:- select distinct(salary)from employees order by salary limit 3


5)Joins


1)	 Write a query to find the addresses (location_id, street_address, city, state_province, country_name) of all the departments.
Ans:- select LOCATION_ID,STREET_ADDRESS,CITY,STATE_PROVINCE,COUNTRY_NAME from locations natural join countries;


2)	 Write a query to find the name (first_name, last name), department ID and department name of all the employees.
Ans:- select FIRST_NAME,LAST_NAME,DEPARTMENT_ID,DEPARTMENT_NAME from employees join departments using (department_id);

3)	Write a query to find the name (first_name, last_name), job, department ID and name of the employees who works in London.
Ans:- select first_name,last_name,job_title,e.department_id,department_name,city
 from employees e join departments d on e.department_id=d.department_id 
 join locations l  on l.location_id=d.location_id join jobs  j
 on e.job_id=j.job_id where city='London';


4)	Write a query to find the employee id, name (last_name) along with their manager_id and name (last_name).
Ans:- select e.EMPLOYEE_ID,e.LAST_NAME,d.EMPLOYEE_ID,d.LAST_NAME 
from employees e  join employees d on e.MANAGER_ID=d.EMPLOYEE_ID;

5)	Write a query to find the name (first_name, last_name) and hire date of the employees who was hired after 'Jones'.
Ans:- select first_name,last_name,hire_date from employees where HIRE_DATE<(select HIRE_DATE from employees where LAST_NAME='jones');

6)	Write a query to get the department name and number of employees in the department. 
Ans:-select department_name,count(*) from departments inner join employees on employees.department_id=departments.department_id group by departments.department_id,department_name;



7)	Write a query to find the employee ID, job title, number of days between ending date and starting date for all jobs in department 90.
Ans:- select Employee_id,job_title,(jh.end_date-jh.start_date)
from job_history jh natural join jobs where department_id=90;
 
8)	Write a query to display the department ID and name and first name of manager.
Ans:- select d.DEPARTMENT_ID,DEPARTMENT_NAME,FIRST_NAME 
from employees e join departments d on e.EMPLOYEE_ID=d.MANAGER_ID order by d.DEPARTMENT_ID

9)	Write a query to display the department name, manager name, and city.
Ans:- select DEPARTMENT_NAME,FIRST_NAME,CITY from employees e join departments d on e.EMPLOYEE_ID=d.MANAGER_ID join locations l on l.LOCATION_ID=d.LOCATION_ID ;

10)	Write a query to display the job title and average salary of employees.
Ans:- select JOB_TITLE,avg(SALARY) from employees natural join jobs  group by JOB_TITLE;

11)	Write a query to display job title, employee name, and the difference between salary of the employee and minimum salary for the job.
Ans:- select JOB_TITLE,FIRST_NAME,(SALARY-MIN_SALARY)diff from employees natural join jobs


12)	Write a query to display the job history that were done by any employee who is currently drawing more than 10000 of salary.
Ans:- select jh.* from job_history jh 
join employees e on jh.EMPLOYEE_ID=e.EMPLOYEE_ID where salary>10000;




13)	Write a query to display department name, Department Manager (first_name, last_name), hire date of manager, salary of the manager for those managers whose experience is more than 15 years.
Ans:- select department_name,first_name,last_name,hire_date,salary
 from departments d join employees e on (d.manager_id=e.employee_id) 
 where (DATEDIFF(now(),hire_date))/365>15







