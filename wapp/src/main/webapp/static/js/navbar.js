function navbar(idPage) {
    this.page = idPage;
}

navbar.prototype.init = function () {
    $('#menu-home').removeClass("active");
    $('#menu-user').removeClass("active");
    $('#menu-follow').removeClass("active");
    if (/^#/.test(this.page) || /^./.test(this.page)) {
        $(this.page).addClass("active");
    }
}