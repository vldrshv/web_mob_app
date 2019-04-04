package com.bmstu.video

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.view.InternalResourceViewResolver
import org.springframework.web.servlet.view.JstlView

@Configuration
class JspConfig {
    @Value("\${spring.view.prefix}")
    private val prefix: String? = null

    @Value("\${spring.view.suffix}")
    private val suffix: String? = null

    @Value("\${spring.view.view-names}")
    private val viewNames: String? = null

    @Bean
    internal fun jspViewResolver(): InternalResourceViewResolver {
        val viewResolver = InternalResourceViewResolver()
        viewResolver.setPrefix(prefix)
        viewResolver.setSuffix(suffix)
        viewResolver.setViewClass(JstlView::class.java)
        viewResolver.setViewNames(viewNames)
        return viewResolver
    }
}