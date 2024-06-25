


#1 al risultato. Quando n è 1 ci si ferma.
#Ad esempio, la sequenza di Collatz di 7 è: 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
#E' un noto problema aperto stabilire se ogni sequenza di Collatz termina (cioè, se arriva a 1). Scrivere in linguaggio assemblativo MIPS/MARS una funzione che, dato un numero, dia il successivo in una sequenza di Collatz. Quindi, usare la funzione in un programma che chiede all’utente un numero e mostra la sequenza di Collatz del numero e la lunghezza.
#Esempi di funzionamento
#Numero: 7
#7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
#Lunghezza: 17
#Numero: 9 9 28 14 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
#Lunghezza: 20

.data


.text
main:

xor $t9, $t9, $t9

li $v0, 5       # Carica il codice syscall per la lettura di un intero
syscall         # Esegui la syscall per leggere l'input dall'utente

move $a0, $v0   # Salva l'input letto nel registro $a0

jal seqCollaz

li $v0, 10     
syscall 


seqCollaz:
beq $a0, 1, end
rem $t0, $a0, 2
beqz $t0, isPari
mul $a0, $a0, 3
addi $a0, $a0, 1
addi $t9, $t9, 1
j seqCollaz

isPari:
div $a0, $a0, 2
addi $t9, $t9, 1
j seqCollaz

end:
move $a0, $t9
li $v0, 1       
syscall 

jr $ra
