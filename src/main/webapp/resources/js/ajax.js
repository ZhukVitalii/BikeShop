function addToCart(name,article) {
    var URL = "/cartAdd";
    $.ajax({
        method: "POST",
        url: URL+"/"+name+"/"+article,
        data: name,
        data:article,
        cache: false
    });
    /*
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL+article, true);
    xhttp.send(article);
*/
}
/*
function deleteFromCart(name,article) {
    var quantity = document.getElementById(article).textContent;
    var URL = "/cartDel"
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL+"/"+name+"/"+article+"/"+quantity, true);
    xhttp.send(name,article,quantity);
    window.location.reload();
}
*/
function deleteFromCart(name,article) {
    var quantity = document.getElementById(article).textContent;
    var URL = "/cartDel";
    $.ajax({
        method: "POST",
        url: URL+"/"+name+"/"+article+"/"+quantity,
        data: name,
        data:article,
        data:quantity,
        cache: false,
        success: function (html) {
            window.location.reload();
        }
    });
}