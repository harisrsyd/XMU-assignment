# Book API Spec

## Create/Insert new Book

Endpoint : POST /api/books

Request Body :

```json
{
  "title" : "Atomic Habits",
  "publishYear" : "2021",
  "author" : "James Clear",
  "publisher" : "Gramedia Pustaka Utama",
  "isbn" : "9786020667188",
  "language" : "Indonesia",
  "notes" : "Buku ini berisi kisah-kisah para peraih mendali emas Olimpiade, CEO terkemuka, dan ilmuan-ilmuan istimewa yang telah menggunakan sains tentang kebiasaan-kebiasaan kecil untuk tetap produktif, tetap termotivasi dan bahagia."
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "long-identity",
    "title": "Atomic Habits",
    "publishYear": "2021",
    "author": "James Clear",
    "publisher": "Gramedia Pustaka Utama",
    "isbn": "9786020667188",
    "language": "Indonesia",
    "notes": "Buku ini berisi kisah-kisah para peraih mendali emas Olimpiade, CEO terkemuka, dan ilmuan-ilmuan istimewa yang telah menggunakan sains tentang kebiasaan-kebiasaan kecil untuk tetap produktif, tetap termotivasi dan bahagia."
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "ISBN format invalid, publishYear invalid, ..."
}
```

## Update Book

Endpoint : PUT /api/books/{idBook}

Request Body :

```json
{
  "title" : "Atomic Habits",
  "publishYear" : "2021",
  "author" : "James Clear",
  "publisher" : "Gramedia Pustaka Utama",
  "isbn" : "9786020667188",
  "language" : "Indonesia",
  "notes" : "Buku ini berisi kisah-kisah para peraih mendali emas Olimpiade, CEO terkemuka, dan ilmuan-ilmuan istimewa yang telah menggunakan sains tentang kebiasaan-kebiasaan kecil untuk tetap produktif, tetap termotivasi dan bahagia."
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "long-identity",
    "title": "Atomic Habits",
    "publishYear": "2021",
    "author": "James Clear",
    "publisher": "Gramedia Pustaka Utama",
    "isbn": "9786020667188",
    "language": "Indonesia",
    "notes": "Buku ini berisi kisah-kisah para peraih mendali emas Olimpiade, CEO terkemuka, dan ilmuan-ilmuan istimewa yang telah menggunakan sains tentang kebiasaan-kebiasaan kecil untuk tetap produktif, tetap termotivasi dan bahagia."
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "ISBN format invalid, publishYear invalid, ..."
}
```

## Get Book

Endpoint : GET /api/books/{idBook}

Response Body (Success) :

```json
{
  "data": {
    "id": "long-identity",
    "title": "Atomic Habits",
    "publishYear": "2021",
    "author": "James Clear",
    "publisher": "Gramedia Pustaka Utama",
    "isbn": "9786020667188",
    "language": "Indonesia",
    "notes": "Buku ini berisi kisah-kisah para peraih mendali emas Olimpiade, CEO terkemuka, dan ilmuan-ilmuan istimewa yang telah menggunakan sains tentang kebiasaan-kebiasaan kecil untuk tetap produktif, tetap termotivasi dan bahagia."
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "Book is not found"
}
```

## Search Book

Endpoint : GET /api/books/search

Query Param :

Query Param :

- title : String, book title, using like query, optional
- author : String, book author, using like query, optional
- publisher : String, book publisher, using like query, optional
- page : Integer, start from 0, default 0
- size : Integer, default 10

Response Body (Success) :

```json
{
  "data": [
    {
      "id": "long-identity",
      "title": "Atomic Habits",
      "publishYear": "2021",
      "author": "James Clear",
      "publisher": "Gramedia Pustaka Utama",
      "isbn": "9786020667188",
      "language": "Indonesia",
      "notes": "Buku ini berisi kisah-kisah para peraih mendali emas Olimpiade, CEO terkemuka, dan ilmuan-ilmuan istimewa yang telah menggunakan sains tentang kebiasaan-kebiasaan kecil untuk tetap produktif, tetap termotivasi dan bahagia."
    }
  ],
  "paging" : {
    "currentPage" : 0,
    "totalPage" : 10,
    "size" : 10
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "Unauthorized"
}
```

## Remove Book

Endpoint : DELETE /api/books/{idBook}

Response Body (Success) :

```json
{
  "data" : "OK"
}
```

Response Body (Failed) :

```json
{
  "errors" : "Contact is not found"
}
```