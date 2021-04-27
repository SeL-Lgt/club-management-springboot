package com.lgt.clubmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan("com.lgt.clubmanagement.controller")
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket getUserDocket() {
        Contact contact = new Contact("lgt", "localhost:9090", "122790345@qq.com");
        ApiInfo apiInfo = new ApiInfoBuilder()
                //api标题
                .title("高校社团事务管理信息系统")
                //api描述
                .description("高校社团事务管理信息系统相关接口描述")
                //版本号
                .version("1.0.0")
                //本API负责人的联系信息
                .contact(contact)
                .build();
                //文档类型（swagger2）
        return new Docket(DocumentationType.SWAGGER_2)
                //设置包含在json ResourceListing响应中的api元信息
                .apiInfo(apiInfo)
                //启动用于api选择的构建器
                .select()
                //扫描接口的包
                .apis(RequestHandlerSelectors.basePackage("com.lgt.clubmanagement.controller"))
                //路径过滤器（扫描所有路径）
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 防止@EnableMvc把默认的静态资源路径覆盖了，手动设置的方式
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决静态资源无法访问
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2) // DocumentationType.SWAGGER_2 固定的，代表swagger2
//                //  .groupName("分布式任务系统") // 如果配置多个文档的时候，那么需要配置groupName来分组标识
//                .apiInfo(apiInfo()) // 用于生成API信息
//                .select() // select()函数返回一个ApiSelectorBuilder实例,用来控制接口被swagger做成文档
//                .apis(RequestHandlerSelectors.basePackage("com.lgt.clubmanagement.controller")) // 用于指定扫描哪个包下的接口
//                .paths(PathSelectors.any())// 选择所有的API,如果你想只为部分API生成文档，可以配置这里
//                .build();
//    }
//
//    /**
//     * 用于定义API主界面的信息，比如可以声明所有的API的总标题、描述、版本
//     *
//     * @return
//     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("XX项目API") // 可以用来自定义API的主标题
//                .description("XX项目SwaggerAPI管理") // 可以用来描述整体的API
//                .termsOfServiceUrl("") // 用于定义服务的域名
//                .version("1.0") // 可以用来定义版本。
//                .build(); //
//    }