load data
infile 'C:\Users\lakho\Desktop\DBSproject\employee.csv'
into table employee
fields terminated by ","
(
	employee_id,
	employee_name,
	gender,
	phone,
	department_id
)