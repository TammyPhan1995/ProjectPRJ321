function checkValid() {
    var searchValue = document.forms["searchForm"]["txtSearch"].value;
    if (searchValue.trim().length === 0) {
        alert("Search Field can not be blank");
        return false;
    }
    return true;
}