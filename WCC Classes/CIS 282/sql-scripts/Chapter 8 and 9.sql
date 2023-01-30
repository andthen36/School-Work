----- Chapter 8 ----- 

Select *
From Invoice8

Select InvoiceID, InvoiceNumber, InvoiceDate
FROM Invoice8

Select InvoiceID, InvoiceNumber, CONVERT(nvarchar, InvoiceDate , 107)as ModDate
FROM Invoice8

Select InvoiceID, InvoiceNumber, CAST(InvoiceDate as nvarchar(11))as ModDate
FROM Invoice8

Select InvoiceID, InvoiceNumber, Convert(nvarchar, InvoiceNumber) + '-' + Cast(InvoiceID as nvarchar) as 'invoice#-id'
FROM Invoice8

Select InvoiceID, InvoiceNumber, CONCAT(InvoiceNumber, '-', InvoiceID) as 'invoice#-id'
FROM Invoice8

Select CONVERT(nvarchar(11), InvoiceDate ) as InvoiceDate, COUNT(InvoiceDate) as CountInvoices
FROM Invoice8
group by CONVERT(nvarchar(11), InvoiceDate )

Select CAST(InvoiceDate as Date) as InvoiceDate, COUNT(InvoiceDate) as CountInvoices
FROM Invoice8
group by CAST(InvoiceDate as Date)

----- Chapter 9 ----- 

SELECT ISNULL(null, 'Missing Value')
From Invoice8

Select ISNULL(InvoiceNumber, 'Missing Invoice') as InvoiceNumber
From Invoice8

Select  coalesce(InvoiceNumber, 'Missing Invoice') as InvoiceNumber
From Invoice8

Select case when InvoiceNumber is null then 'Missing Invoice' else InvoiceNumber end as InvoiceNumber
From Invoice8

Select *
from Emp

Select coalesce(FName, LName, 'Missing Name') as Name, [Phone Number]
from Emp

