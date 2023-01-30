-- select statment that uses a subquery in the where clause
SELECT InvoiceNumber, InvoiceDate, InvoiceTotal
FROM Invoices
WHERE InvoiceTotal >
	(SELECT AVG(InvoiceTotal)
	FROM Invoices)
Order by InvoiceTotal

--- query that uses a inner join
select InvoiceNumber, InvoiceDate, InvoiceTotal
from Invoices join AP_Vendors on Invoices.VendorID = AP_Vendors.VendorID
where VendorState = 'CA'
order by InvoiceDate

-- same query restated with a subquery
select InvoiceNumber, InvoiceDate, InvoiceTotal
from Invoices
where VendorID in (Select VendorID from AP_Vendors where VendorState = 'CA')
order by InvoiceDate

--- query that returns bedors without invoices
Select VendorID, VendorName, VendorState
from AP_Vendors
where VendorID not in (select distinct VendorID from Invoices)
order by VendorID

--- query restated without a subquery
select v.VendorID, VendorName, VendorState
from AP_Vendors v left join Invoices i on v.VendorID = i.VendorID
where i.VendorID is null
order by v.VendorID

--- comparing reults of subquery with an expression
select InvoiceNumber, InvoiceDate,
	InvoiceTotal - PaymentTotal - CreditTotal as balance_due
from Invoices
where InvoiceTotal - PaymentTotal - CreditTotal > 0 
	and InvoiceTotal - PaymentTotal - CreditTotal < 
	(SELECT AVG(InvoiceTotal - PaymentTotal - CreditTotal)
	from Invoices
	where InvoiceTotal - PaymentTotal - CreditTotal > 0)
order by InvoiceTotal desc

-- query that returns larger than larget invoice for vendor 34 using ALL
select VendorName, InvoiceNumber, InvoiceTotal
from Invoices i join AP_Vendors v on i.VendorID = v.VendorID
where InvoiceTotal > ALL
	(select InvoiceTotal from Invoices where VendorID =34)
order by VendorName

-- query that returns invoice amount smaller that the largest invoice amount from vendor 115
select VendorName, InvoiceNumber, InvoiceTotal
from AP_Vendors join Invoices on AP_Vendors.VendorID = Invoices.VendorID
where InvoiceTotal < any
	(select InvoiceTotal from Invoices where VendorID = 115)


