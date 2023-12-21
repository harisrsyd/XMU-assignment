$(document).ready(function () {

    fillTable(0, 5, '');

    $('#search').keypress(function (e) {
        if (e.which == 13)  // the enter key code
        {
            var cari = $(this).val()
            fillTable(0, 5, cari)
        }
    });

    $('#searchbtn').click(function () {
        var cari = $('#search').val()
        fillTable(0, 5, cari)
    })

    $('#refresh').click(function () {
        fillTable(0, 5, '')
    })

    $('#addData').click(function () {
        $.ajax({
            url: 'http://localhost/add',
            type: 'GET',
            dataType: 'html',
            success: function (data) {
                $('#modalBooks').modal('show')
                $('.idModalTitle').html('Add Collection Book')
                $('.isiModal').html(data)
            }
        })
    })

    function fillTable(page, size, search) {
        $.ajax({
            url: 'http://localhost/api/books/search?page=' + page + '&size=' + size + '&search=' + search,
            type: 'GET',
            success: function (data) {
                if (data.totalElements == 0) {
                    $('#booksTable').html('<h3 class="text-center">Book not Found!!</h3>')
                } else {
                    var txt = ''
                    txt += '<table class="table table-hover"><thead><tr>'
                    txt += '<th>ID</th><th>Title</th><th>PubYear</th><th>Author</th><th>Publisher</th><th>ISBN</th><th>Action</th>'
                    txt += '</tr></thead>'
                    txt += '<tbody>'
                    for (let i = 0; i < data.content.length; i++) {
                        txt += '<tr>'
                        txt += '<td id="id">' + data.content[i].id + '</td>'
                        txt += '<td>' + data.content[i].title + '</td>'
                        txt += '<td>' + data.content[i].publishYear + '</td>'
                        txt += '<td>' + data.content[i].author + '</td>'
                        txt += '<td>' + data.content[i].publisher + '</td>'
                        txt += '<td>' + data.content[i].isbn + '</td>'
                        txt += '<td> <input type="button" value="Edit" name="' + data.content[i].id + '" class="editbtn btn btn-warning"> '
                        txt += ' <input type="button" value="Delete" name="' + data.content[i].id + '" class="deletebtn btn btn-danger"> </td>'
                        txt += '</tr>'
                    }
                    txt += '</tbody></table>'
                    $('#booksTable').html(txt)

                    let tpage = data.totalPages;
                    let ptxt = ""
                    ptxt += '<button class="btn info"> << </button>'
                    for (p = 1; p <= tpage; p++) {
                        ptxt += '<button class="btn pagingBtn" value="' + p + '"> ' + p + ' </button>'
                    }
                    ptxt += '<button class="btn info"> >> </button>'
                    $('#tablePagination').html(ptxt)
                }
                $('.pagingBtn').click(function () {
                    var page = $(this).val() - 1
                    fillTable(page, size, search)
                })

                $('.editbtn').click(function () {
                    var id = $(this).attr('name')
                    //session storage
                    sessionStorage.setItem('ids', id)
                    editData()
                })

                $('.deletebtn').click(function () {
                    var id = $(this).attr('name')
                    //session storage
                    sessionStorage.setItem('ids', id)
                    deleteData()
                })
            }
        })
    }

    $('#submitData').click(function () {
        var obj = {}
        obj.title = $('#title').val()
        obj.author = $('#author').val()
        obj.publishYear = $('#publishYear').val()
        obj.publisher = $('#publisher').val()
        obj.language = $('#language').val()
        obj.isbn = $('#isbn').val()
        obj.notes = $('#notes').val()

        var dJson = JSON.stringify(obj)
        $.ajax({
            url: 'http://localhost/api/books',
            type: 'POST',
            contentType: 'application/json',
            data: dJson,
            success: function (data) {
                // alert(data.id)
                backDashboard()
            }
        })
    })

    function getById() {
        var id = sessionStorage.getItem('ids')
        $.ajax({
            url: 'http://localhost/api/books/' + id,
            type: 'GET',
            success: function (data) {
                $('#idPlace').append(data.id)
                $('#title').val(data.title)
                $('#author').val(data.author)
                $('#publishYear').val(data.publishYear)
                $('#publisher').val(data.publisher)
                $('#language').val(data.language)
                $('#isbn').val(data.isbn)
                $('#notes').val(data.notes)
            }
        })
    }

    function editData() {
        $.ajax({
            url: 'http://localhost/edit',
            type: 'GET',
            dataType: 'html',
            success: function (data) {
                $('#modalBooks').modal('show')
                $('.idModalTitle').html('Edit Book Data')
                $('.isiModal').html(data)
                getById()
            }
        })
    }

    $('#submitChange').click(function () {
        var obj = {}
        obj.title = $('#title').val()
        obj.author = $('#author').val()
        obj.publishYear = $('#publishYear').val()
        obj.publisher = $('#publisher').val()
        obj.language = $('#language').val()
        obj.isbn = $('#isbn').val()
        obj.notes = $('#notes').val()
        var dJson = JSON.stringify(obj)
        var id = sessionStorage.getItem('ids')
        $.ajax({
            url: 'http://localhost/api/books/'+ id,
            type: 'PUT',
            contentType: 'application/json',
            data: dJson,
            success: function (data) {
                // alert(data.id)
                backDashboard()
            }
        })
    })

    function deleteData() {
        $.ajax({
            url: 'http://localhost/delete',
            type: 'GET',
            dataType: 'html',
            success: function (data) {
                $('#modalBooks').modal('show')
                $('.idModalTitle').html('Remove Book Data')
                $('.isiModal').html(data)
                getById()
            }
        })
    }

    $('#deletebtn').click(function () {
        var id = sessionStorage.getItem('ids')
        $.ajax({
            url: 'http://localhost/api/books/' + id,
            type: 'DELETE',
            contentType: 'application/json',
            success: function (data) {
                // alert("Delete success")
                backDashboard()
            }
        })
    })

    $('#cancelbtn').click(function () {
        $.ajax({
            url: 'http://localhost/manage',
            type: 'GET',
            dataType: 'html',
            success: function (data) {
                $('#modalBooks').modal('hide')
            }
        })
    })

    function backDashboard() {
        $.ajax({
            url: 'http://localhost/manage',
            type: 'GET',
            dataType: 'html',
            success: function (data) {
                $('#modalBooks').modal('hide')
            }
        })
    }

})