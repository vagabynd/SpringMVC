$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/api/user/8"
    }).then(function(data) {
        $('.user-id').append(data.id);
        $('.user-name').append(data.name);
        $('.user-email').append(data.email);
        $('.user-age').append(data.age);
    });
});