package eco.tool

class EcoToolValues {

    String indicator
    String name
    String value
    String unit

    static constraints = {
        unit nullable: true
        value nullable: true
    }

}
