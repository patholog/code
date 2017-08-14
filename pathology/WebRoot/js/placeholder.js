//让input支持placeholder
$(function () {
  if (!placeholderSupport()) {   // 判断浏览器是否支持 placeholder
    $('[placeholder]').focus(function () {
      var input = $(this);
      if (input.val() == input.attr('placeholder')) {
        if (input.attr("id") == "textPw") {
          $("#txtPassword").val('');
          $("#txtPassword").css("display", "block");
          $("#textPw").css("display", "none");
          $("#txtPassword").click();
          $("#txtPassword").focus();
        } else if (input.attr("id") == "txtPassword") {
          $("#txtPassword").val('');
          $("#txtPassword").css("display", "block");
          $("#textPw").css("display", "none");
          input.val('');
        } else {
          input.val('');
          input.removeClass("gray");
          input.addClass("black");
        }
      }
    }).blur(function () {
      var input = $(this);
      if (input.val() == '' || input.val() == input.attr('placeholder')) {
        if (input.attr("id") == "textPw") {
          $("#txtPassword").val('');
          $("#txtPassword").css("display", "block");
          $("#textPw").css("display", "none");
          input.val(input.attr('placeholder'));
        } else if (input.attr("id") == "txtPassword") {
          $("#txtPassword").val('');
          $("#txtPassword").css("display", "none");
          $("#textPw").css("display", "block");
          $("#textPw").val(input.attr('placeholder'));
        } else {
          input.val(input.attr('placeholder'));
          input.removeClass("black");
          input.addClass("gray");
        }
      }
    }).blur();
  }

})
function placeholderSupport() {
  return 'placeholder' in document.createElement('input');
}
