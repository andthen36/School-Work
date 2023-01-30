--counts unpaid invoices and calculates the total due
SELECt COUNT(*) as number_of_invoices,
		sum(InvoiceTotal - PaymentTotal - CreditTotal) as total_due
from Invoices
where InvoiceTotal - PaymentTotal - CreditTotal >0

-- using Count, avg, and sum fuction
SELECT 'After 1/1/2012' AS selection_date,
	COUNT(*) as numberOfInvoices,
	ROUND(AVG(InvoiceTotal), 2) as avgInvoiceAMT,
	sum(InvoiceTotal)as totalInvoiceAMT
From Invoices
where InvoiceDate > '2012-01-01'

--using min max function
Select MIN(VendorName) as first_vendor,
		MAX(VendorName) as last_vendor,
		COUNT(VendorName) as number_of_vendors
from AP_Vendors

-- using DISTINCT keyword in a fuction
Select COUNT(DISTINCT VendorID) as number_of_vendors,
	COUNT(VendorID)as number_of_invoices
from Invoices


--------------------------------------------
-- How to group and summarize data
--------------------------------------------

-- count of invoices by vendor
SELECT VendorID,
		count(*) as invoice_qty
FROM Invoices
Group By VendorID

--summary query that calculates the average invoice total by vendor
SELECT VendorID,
		ROUND(AVG(InvoiceTotal),2) as avg_invoice_amount
FROM Invoices
Group By VendorID
HAVING AVG(InvoiceTotal) > 2000

-- summary query that calcs the number of incoices and average invoice total by state and city
SELECT VendorState, VendorCity, COUNT(*) as invoice_qty,
		ROUND(AVG(InvoiceTotal), 2) as invoice_avg
from Invoices JOIN AP_Vendors on Invoices.VendorID = AP_Vendors.VendorID
group by VendorState, VendorCity
order by VendorState, VendorCity

--same as above but it fiters data to show only >= 2
SELECT VendorState, VendorCity, COUNT(*) as invoice_qty,
		ROUND(AVG(InvoiceTotal), 2) as invoice_avg
from Invoices JOIN AP_Vendors on Invoices.VendorID = AP_Vendors.VendorID
group by VendorState, VendorCity
HAVING COUNT(*) >=2
order by VendorState, VendorCity

--query with a filtering condition in the HAVING clause
SELECT VendorName, COUNT(*) as invoice_qty,
	ROUND(AVG(InvoiceTotal), 2) as invoice_avg
FROM AP_Vendors JOIN Invoices
	ON AP_Vendors.VendorID = Invoices.VendorID
Group by VendorName
having AVG(InvoiceTotal) > 500
order by invoice_qty DESC

--query with a filtering condition in the WHERE clause
SELECT VendorName, COUNT(*) as invoice_qty,
	ROUND(AVG(InvoiceTotal), 2) as invoice_avg
FROM AP_Vendors JOIN Invoices
	ON AP_Vendors.VendorID = Invoices.VendorID
where InvoiceTotal > 500
Group by VendorName
order by invoice_qty DESC

--compound filter condtion in HAVING clause
Select InvoiceDate, Count(*) as invoice_qty, SUM(InvoiceTotal) as invoice_sum
from Invoices
group by InvoiceDate
having InvoiceDate BETWEEN '2012/03/01' and '2012/03/31'
and COUNT(*) >1
and sum(InvoiceTotal) > 100
order by InvoiceDate desc

--compound filter condtion in WHERE clause
Select InvoiceDate, Count(*) as invoice_qty, SUM(InvoiceTotal) as invoice_sum
from Invoices
WHERE InvoiceDate BETWEEN '2012/03/01' and '2012/03/31'
group by InvoiceDate
HAVING COUNT(*) >1
and sum(InvoiceTotal) > 100
order by InvoiceDate desc