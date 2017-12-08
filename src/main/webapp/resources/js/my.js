
function add(URL, price, article) {
    $.ajax({
        method: "POST",
        url: URL+price,
        data: price,
        cache: false,
        success: function (html) {
            changeTotal();
            upNumber(article);
            changePrice();
        }
    });
}
function remove(URL, price, article) {
    var quantity = document.getElementById(article).textContent;
    if (quantity > 1) {
        $.ajax({
            method: "POST",
            url: URL + price,
            data: price,
            cache: false,
            success: function (html) {
                changeTotal();
                downNumber(article);
                changePrice();
            }
        });
    }
}
function changeCounting(article) {
    $.ajax({
        method: "POST",
        url: "/counting/"+article,
        data: article,
        cache: false,
        success: function (html) {
            $("#"+article).html(html);
        }
    });
}

function changePrice() {
    $.ajax({
        url: "/price",
        cache: false,
        success: function (html) {
            $("#total-price").html(html);

        }
    });
}

function changeTotal() {
    $.ajax({
        url: "/totalNumber",
        cache: false,
        success: function (html) {
            $("#total-number").html(html);
        }
    });
}
$(document).ready(function(){
    changeTotal();
    setInterval('changeTotal()',100);
});
$(document).ready(function(){
    changePrice();
    setInterval('changePrice()',100);
});

function upNumber(article) {
    $.ajax({
        method: "POST",
        url: "/upNumber/"+article,
        data: article,
        success: function (html) {
            changeCounting(article);
        }
    });
}
function downNumber(article) {
    $.ajax({
        method: "POST",
        url: "/downNumber/"+article,
        data: article,
        success: function (html) {
            changeCounting(article);
        }
    });
}
