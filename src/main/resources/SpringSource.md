Spring容器的refresh()【创建刷新】

1、prepareRefresh()刷新前的预处理；
    
    1）、initPropertySources()初始化一些属性设置；子类自定义个性化的属性设置方法；
    2）、getEnvironment().validateRequiredProperties();检验属性的合法性等
    3）、earlyApplicationEvents = new LinkedHashSet();保存容器中的一些早期的事件

2、obtainFreshBeanFactory();获取BeanFactory
    
    1）、refreshBeanFactory();刷新BeanFactory
        创建了一个this.beanFactory = new DefaultListableBeanFactory();
        设置id;
    2）、getBeanFactory();返回刚才GenericApplicationContext创建的BeanFactory对象；
    3）、将创建的BeanFactory【DefaultListableBeanFactory】返回

3、prepareBeanFactory(beanFactory);BeanFactory的预准备工作（BeanFactory进行一些设置）
    
    1）、设置BeanFactory的类加载器、支持表达式解析……
    2）、添加部分BeanPostProcessor【ApplicationContextAwareProcessor】
    3）、设置忽略的自动装配的接口EnvironmentAware、EmbeddedValueResolverAware、XXX
    4）、注册可以自动解析的自动装配；我们能直接在任何组件中自动注入；
            BeanFactory、ResourceLoader、ApplicationEventPublisher、ApplicationContext
    5）、添加BeanPostProcessor【ApplicationListenerDetector】
    6）、添加编译时的AspectJ；
    7）、给BeanFactory中注册一些能用的组件
        environment【ConfigurableEnvironment】
        systemProperties【Map<String, Object>】
        systemEnvironment【Map<String, Object>】

4、postProcessBeanFactory(beanFactory);BeanFactory准备工作完成后进行的后置处理工作；
    
    1）、子类通过重写这个方法来在BeanFactory创建并预准备完成以后做进一步的设置

==============================以上是BeanFactory的创建及预准备工作================================

