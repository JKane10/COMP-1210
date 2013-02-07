   
   /**
    * Classes implementing this interface represent events
	 * that would be placed on a 'to do' list. Items must have
	 * a description and whether or not they are completed.
	 * Items implementing this inteface should default to 
	 * non-completed (i.e. isComplete returns true unless 
	 * setComplete has been invoked with a false parameter).
	 *
	 * @author Lauren Goff
	 * @version 3-25-2011
    */
   public interface ToDoItemInterface {
   
      /**
       * Sets the description for the item only if the description
   	 * string contains non-whitespace and is not null.
       *
       * @param descriptionIn The item's description.
   	 * @return true if the description was set, false otherwise.
       */
      boolean setDescription(String descriptionIn);  
   	
      /**
       * Returns the description for the item.
       *
       * @return The item's description.
       */
      String getDescription();
        
      /**
       * Sets whether the to do item has been completed.
       *
       * @param completed true if item is completed, false otherwise.
       */
      void setComplete(boolean completed);
        
      /**
       * Returns whether the to do item has been completed.
       *
       * @return true if the item has been completed, false otherwise.
       */
      boolean isComplete();
   }