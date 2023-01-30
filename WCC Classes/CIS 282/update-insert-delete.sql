-------------------------------------
---- HOW TO CREATE TEST TABLES
-------------------------------------

------ Statement that creates a complete copy of invoices copy

SELECT *
INTO InvoicesCopy
from AP_Invoices

select *
from InvoiceCopy

--- statement that creates partial copy of invoices table
SELECT *
INTO OldInvoices
From Invoices
where InvoiceTotal - PaymentTotal - CreditTotal =0

--- statement that creates a table with summary rows from invoices table

SELECT VendorID, SUM(InvoiceTotal) as sum_of_invoices
INTO VendorBalance
from Invoices
where (InvoiceTotal-PaymentTotal-CreditTotal)<>0
group by VendorID


---statement that deletes a table
drop table InvoicesCopy


-------------------------------------
---- HOW TO COMMIT AND ROLLBACK CHANGES
-------------------------------------

--insert that adds a new rom to invoices table
INSERT INTO Invoices
VALUES (97, '456789', '2016-04-01', 8344.50, 0, 0, 1,'2016-04-30', NULL)

--- COMMIT CHANGE
COMMIT;

--- Roll back before you save
ROLLBACK;

CREATE TABLE ColorSample
(
	ID Int IDENTITY(1,1) NOT NULL,
	ColorNumber INT NOT NULL DEFAULT '0',
	ColorName varchar(10),
)

insert into ColorSample (ColorNumber)
values (606)

insert into ColorSample (ColorName)
VALUEs ('Yellow')

insert into ColorSample
values (DEFAULT, 'Orange')

insert into ColorSample
values (808, NULL)

insert into ColorSample
default values

select * from ColorSample

--- INSERT paid invoices in the invoice copy table into invoiceArchive table
INSERT INTO InvoiceArchive
SELECT *
from OldInvoices
WHERE InvoiceTotal - PaymentTotal- CreditTotal = 0

UPDATE OldInvoices
set PaymentDate = '2016-05-21',
	PaymentTotal = 19351.18
where InvoiceNumber = '97/522'
--update statement that assigns the maximum due date in the invoice copy to a specific invoice
UPDATE OldInvoices
SET CreditTotal = CreditTotal + 100,
	InvoiceDueDate = (SELECT MAX(InvoiceDueDate) FROM OldInvoices)
	where InvoiceNumber = '97/522'

--update all the invoices for a vendor base on vendor name
SELECT *
INTO VendorCopy
from AP_Vendors

UPDATE Invoice
SET TermsID = 1
WHERE VendorID = 
		(SELECT VendorID
			FROM VendorCopy
			Where VendorName = 'Pacific Bell')


DELETE InvoiceCopy
where InvoiceID = 115
