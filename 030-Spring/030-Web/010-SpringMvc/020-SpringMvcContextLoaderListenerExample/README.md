# ContextLoaderListener

**ContextLoaderListener** creates **Root Web Application Context** while **DispatcherServlet** creates **Web Application Context**.

If ContextLoaderListener is used together with DispatcherServlet, Root Web Application Context would be created before Web Application Context (Child of Root Web Application Context).

