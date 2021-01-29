package com.royalsoftsolutions.uiadddailyreport

class RecyclerItem(no: String?,title: String?, file64: String?, option: String?) {

    private var no: String?
    private var title: String?
    private var file64: String?
    private var option: String?

    init {
      this.no = no
        this.title = title
        this.file64 = file64
        this.option = option

    }

    fun getno(): String? {
        return no
    }
    fun setno(no: String?) {
        title = no
    }

    fun getTitle(): String? {
        return title
    }
    fun setTitle(name: String?) {
        title = name
    }
    fun getFile64(): String? {
        return file64
    }
    fun setFile64(file64: String?) {
        this.file64 = file64
    }
    fun getOption(): String? {
        return option
    }
    fun setOption(option: String?) {
        this.option = option
    }

}
