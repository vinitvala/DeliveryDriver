    /**
     * @author Vinit Vala
     * SBU ID: 114501080
     * Recitation 02
     * Delivery Class that stores Delivery information entered by user
     */

    public class Delivery {

        private String source;
        private String dest;
        private String instruction;

        /**
         * Default constructor for Delivery
         */
        public Delivery() {
            source = "";
            dest = "";
            instruction = "";
        }

        /**
         * Parameterized Constructor for Delivery
         * @param source // source of the delivery
         * @param dest  // Destination of the delivery
         * @param instruction   // Special instructions for the Delivery
         */
        public Delivery(String source, String dest, String instruction){
        this.source=source;
        this.dest=dest;
        this.instruction=instruction;
        }

        /**
         * Accessor method for source
         * @return source
         */
        public String getSource() {
            return source;
        }
        /**
         * Accessor method for Destination
         * @return destination
         */
        public String getDest() {
            return dest;
        }
        /**
         * Accessor method for Instruction
         * @return instruction
         */
        public String getInstruction() {
            return instruction;
        }
        /**
         * Mutator method for Source
         * @param source of the book- String
         */
        public void setSource(String source) {
            this.source = source;
        }
        /**
         * Mutator method for Source
         * @param dest (destination) of the book- String
         */
        public void setDest(String dest) {
            this.dest = dest;
        }
        /**
         * Mutator method for Instruction
         * @param instruction of the book- String
         */
        public void setInstruction(String instruction) {
            this.instruction = instruction;
        }

        /**
         * to String method for printing all the details of the delivery
         * @return String
         */
        public String toString() {
            return " To: "+getDest()+" | From: "+getSource()+"\n Instruction: "+getInstruction();
        }
    }

