<#import "/spring.ftl" as spring>
<@spring.message "hello" /> ${springMacroRequestContext.getMessage("guest")}!
