-- finding the highest paid salaery
select ID, name
from Ch4Employee
where Salary = (select MAX(Salary) as s from Ch4Employee)
order by Name

--display the departments that has 2 or more employees work in each department with joins
select DepartName, count(*) as number_of_employees
from Ch4Department d join Ch4Employee e on d.ID = e.Depart_ID
where e.Depart_ID = d.ID and COUNT(*) > 2
group by DepartName



--- lab
select sum(salary) as total_salary
from Ch4Employee

select avg(salary) as total_salary
from Ch4Employee
where Depart_ID = 1

select state, sum(salary) as total_salary
from Ch4Employee
group by state

select Depart_ID, DepartName, sum(salary) as total_salary, count(*) as total_employees
from Ch4Department d left join Ch4Employee e on d.ID = e.Depart_ID
group by Depart_ID ,DepartName

--homework: show the null people as well

select top 1 Name, MAX(Salary)salary
from Ch4Employee
group by name
order by MAX(salary) desc

select state, Depart_ID, sum(Salary) as totalSalary
from Ch4Employee
where state = 'Michigan'
group by state, Depart_ID

select state, sum(Salary) as totalSalary
from Ch4Employee
group by State
having sum(Salary) > 4000

select v.VendorCity,v.VendorState, AVG(InvoiceTotal) as avg_invoice_amount, count(*) as numb_of_invoice
from AP_Invoices i join AP_Vendors v on i.VendorID = v.VendorID
group by v.VendorCity,v.VendorState

select InvoiceNumber, InvoiceDate, InvoiceTotal
from AP_Invoices i join AP_Vendors v on i.VendorID = v.VendorID
where v.VendorState = 'CA'
order by InvoiceDate

select InvoiceNumber, InvoiceDate, InvoiceTotal
from AP_Invoices
where VendorID in (Select VendorID from AP_Vendors where VendorState = 'CA')
order by InvoiceDate


select VendorID, VendorName, VendorState
from AP_Vendors
where VendorID not in (select VendorID from Invoices)
order by VendorID

select v.VendorID, VendorName, VendorState
from AP_Vendors v  LEFT join Invoices i on v.VendorID = i.VendorID
where i.VendorID is null
order by v.VendorID