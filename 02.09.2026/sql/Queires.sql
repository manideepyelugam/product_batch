
-- 1.employee sequence by salary
select emp_name, department, salary, row_number() over (order by salary desc) as row_num
from employees;




-- 2.salary rank across the company
select emp_name, department, salary, rank() over (order by salary desc) as salary_rank
from employees;


-- 3.salary rank without gaps
select emp_name, department, salary, dense_rank() over (order by salary desc) as salary_rank
from employees;



-- 7.highest-paid employee name per department
select emp_name, department, salary, first_value(emp_name) over (partition by department order by salary desc) as highest_paid_employee
from employees;



-- 10. 2nd highest distinct salary employees
select emp_name, department, salary from (select emp_name, department, salary, dense_rank() over (order by salary desc) as salary_rank
from employees) as temp where salary_rank = 2;



-- 5. department-wise salary rank
select emp_name, department, salary, rank() over (partition by department order by salary desc) as salary_rank from employees;


