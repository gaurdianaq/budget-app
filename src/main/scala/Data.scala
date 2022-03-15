
import slick.jdbc.MySQLProfile.api._
import slick.lifted.Tag

class Products(tag: Tag) extends Table[(Int, String, Float, Float)](tag, "PRODUCTS"):
    def id = column[Int]("PROD_ID", O.PrimaryKey)
    def name = column[String]("PROD_NAME")
    def price = column[Float]("PRICE")
    def quantity = column[Float]("QUANTITY")
    def * = (id, name, price, quantity)

class Recipes(tag: Tag) extends Table[(Int, String)](tag, "RECIPES"):
    def id = column[Int]("REC_ID", O.PrimaryKey)
    def name = column[String]("NAME")
    def * = (id, name)

class Recipe_Products(tag: Tag) extends Table[(Int, Int, Int, Float)](tag, "RECIPE_PRODUCTS"):
    def id = column[Int]("REC_PROD_ID", O.PrimaryKey)
    def product_id = column[Int]("PROD_ID")
    def recipe_id = column[Int]("REC_ID")
    def product_quantity = column[Float]("PROD_QUANTITY")
    def product_fk = foreignKey("PROD_FK")