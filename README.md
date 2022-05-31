Project ini bertema tentang perpustakaan. Flow project ini sangat sederhanaa, yaitu CRUD Author, CRUD Customer, CRUD Category, CRUD Book, dan CRUD Loan. Database SQL yang digunakan sudah disertakan dalam project ini dengan nama Winterhold. Untuk testing, saya menggunakan Aplikasi Postman dengan URL, Method, Parameter, dan Body sebagai berikut :

1. Find All Author URL : http://localhost7070/author/find-all, Method : GET, Parameter : -, Body : -.
2. Find All Author By Name URL : http://localhost7070/author/name?name=Mrs, Method : GET, Parameter : name, Body : -.
3. Insert New Author URL : http://localhost7070/author/insert, Method : POST, Parameter : -, Body : {
    "title": "Mrs.",
    "firstName": "Nadia",
    "lastName": "Israq",
    "birthDate": "21 Juli 1999",
    "deceasedDate": "21 Juni 2000",
    "education": "A02",
    "summary": "T02"
}.
4. Update Author URL : http://localhost7070/author/16, Method : PUT, Parameter : Id, Body : {
    "title" : "Mrs",
    "firstName": "Dian",
    "lastName": "Ramadhani",
    "birthDate": "1999-07-20",
    "deceasedDate": "1999-07-20",
    "education": "A02",
    "summary": "T02"
}.
5. Delete Author By Id URL : http://localhost7070/author/17, Method : DELETE, Parameter : Id, Body : -.
6. Find All Customer By Name URL : http://localhost7070/customer/find-all, Method : GET, Parameter : -, Body : -.
7. Find Customer By Name URL : http://localhost7070/author//customer/nameCustomer?nameCustomer=asob, Method : GET, Parameter : nameCustomer, Body : -.
8. Insert New Customer URL : http://localhost7070/customer/insert, Method : POST, Parameter : -, Body : {
    "membershipNumber" : "A121",
    "firstName" : "Nadia",
    "lastName" : "Asob",
    "birthDate" : "20 Juli 1999",
    "gender" : "Male",
    "phone" : "082391736781",
    "address" : "Bandung"
}.
9. Update Customer URL : http://localhost7070/customer/A121, Method : PUT, Parameter : membershipNumber, Body : {   
    "firstName" : "Zainul",
    "lastName" : "Rahmat",
    "birthDate" : "1999-07-20",
    "gender" : "Male",
    "phone" : "082391736781",
    "address" : "Bandung"
}.
10. Delete Customer By MembershipNumber URL : http://localhost7070/customer/A121, Method : DELETE, Parameter : membershipNumber , Body : -.
11. Find All Category URL : http://localhost7070/category/find-all, Method : GET, Parameter : -, Body : -.'
12. Find Category By Name URL : http://localhost7070/category/name?name=sejarah, Method : GET, Parameter : name, Body : -.'
13. Insert New Category URL : http://localhost7070/category/insert, Method : POST, Parameter : -, Body : {
    "name" : "Matematika",
    "floor" : 1,
    "isle" : "Sr",
    "bay" : "Bc"
}.
14. Delete Category By Name URL : http://localhost7070/category/Matematika, Method : DELETE, Parameter : name, Body : -.
15. Update Category By Name URL : http://localhost7070/category/Matematika, Method : PUT, Parameter : name, Body : {
    "floor" : 1,
    "isle" : "Ab",
    "bay" : "Cd"
}.
16. Find All Book URL : http://localhost7070/book/find-all, Method : GET, Parameter : -, Body : -.'
17. Find Book By Title URL : http://localhost7070/book/title?title=mewar, Method : GET, Parameter : title, Body : -.'
18. Insert New Book URL : http://localhost7070/book/insert, Method : POST, Parameter : -, Body : {
    "code" : "A180",
    "title" : "Buku Membaca",
    "categoryName" : "Sejarah",
    "authorId" : 16,
    "summary" : "Asd",
    "releaseDate" : "1999-07-20",
    "totalPage" : 24
}.
19. Update Book By Code URL : http://localhost7070/book/A178, Method : PUT, Parameter : code, Body : {
    "title" : "Buku Majalah",
    "categoryName" : "Sejarah",
    "authorId" : 11,
    "borrowed" : 1,
    "summary" : "SDK",
    "releaseDate" : "1999-07-20",
    "totalPage" : 24
}.
20. Delete Book By Code URL : http://localhost7070/book/A180, Method : DELETE, Parameter : code, Body : -.
21. Find All Loan URL : http://localhost7070/loan/find-all, Method : GET, Parameter : -, Body : -.'
22. Find Loan By Customer Number URL : http://localhost7070/loan/number?number=A, Method : GET, Parameter : number, Body : -.'
23. Find Loan By Book Code URL : http://localhost7070/loan/code?code=7, Method : GET, Parameter : number, Body : -.'
24. Insert New Loan URL : http://localhost7070/insert/loan, Method : POST, Parameter : -, Body : {
    "customerNumber" : "A1234",
    "bookCode" : "A166",
    "loanDate" : "1999-07-20",
    "dueDate" : "1999-07-20",
    "returnDate" : null,
    "note" : "Asdsa"
} 
25. Update Loan By Id URL : http://localhost7070/loan/12, Method : PUT, Parameter : Id, Body : {
    "customerNumber" : "A1234",
    "bookCode" : "A166",
    "loanDate" : "1999-07-20",
    "dueDate" : "1999-07-20",
    "returnDate" : "1999-07-20",
    "note" : "Hallo Guys"
}
26. Delete Loan By Id URL : http://localhost7070/loan/11, Method : DELETE, Parameter : Id, Body : - .
