const search_container = document.getElementById("search-container");

const search_input = document.getElementById("search-input");

function buscar(path, value) {
    $.ajax({
        url: path + "/buscar/all?searchText=" + value,
        type: "GET",
        dataType: "html",
        success: function (response){
            search_container.innerHTML = response;
        }
    });

}

search_input.addEventListener("keyup", function (){
    if(this.value !== "") buscar(this.getAttribute("path"), this.value);
});