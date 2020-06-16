load data
infile 'C:\Users\lakho\Desktop\DBSproject\department.csv'
into table department
fields terminated by ","
(
	department_id,
	department_name,
	landline
)