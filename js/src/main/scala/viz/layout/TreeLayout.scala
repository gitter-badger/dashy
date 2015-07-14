package viz.layout

import scala.scalajs.js.annotation.JSExportAll

@JSExportAll
case class ExpandedNode(id: String, depth: Int, x: Double, y: Double, numChildren: Int, parentId: Option[String]) {
  def isLeaf: Boolean = numChildren <= 0
  def isRoot: Boolean = parentId.isEmpty
}

trait TreeLayout extends HierarchyLayout[ExpandedNode] {

  /**
   * [[https://github.com/mbostock/d3/wiki/Tree-Layout#separation]]
   */
  def separation(fn: (Option[String], Int, Option[String], Int) => Double): TreeLayout

  /**
   * [[https://github.com/mbostock/d3/wiki/Tree-Layout#size]]
   */
  def size(x: Double, y: Double): TreeLayout

  /**
   * [[https://github.com/mbostock/d3/wiki/Tree-Layout#nodeSize]]
   */
  def nodeSize(x: Double, y: Double): TreeLayout

  /**
   * [[https://github.com/mbostock/d3/wiki/Tree-Layout#nodes]]
   */
  def nodes(root: Tree): Seq[ExpandedNode] = apply(root)
}
