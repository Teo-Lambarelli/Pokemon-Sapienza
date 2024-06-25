#Si scriva la routine assembler MIPS che implementa la funzione ricorsiva definita come segue:
#f(x,y) = 1 se uno (almeno) tra x,y vale 0
#f(x,y) = x * f(y,x-1) altrimenti
#Si assuma che x, y siano immessi da input sempre maggiori o uguali a 0

#subu $sp, $sp, 4      # Decrementa il puntatore dello stack di 4 byte (dimensione di una word)
#sw   $t0, 0($sp)      # Memorizza il valore in $t0 nella posizione puntata da $sp
#lw   $t0, 0($sp)      # Carica il valore dalla posizione puntata da $sp in $t0
#addu $sp, $sp, 4      # Incrementa il puntatore dello stack di 4 byte (dimensione di una word)

.globl main
.data
y:.word 2
x:.word 2
.text
main:
lw $a0, y
lw $a1, x

jal funzione
move $a0, $v0
li $v0, 1
syscall
li $v0, 10
syscall
funzione:
beqz $a0 caso_base
beqz $a1 caso_base

subu $sp, $sp, 4
sw $a1, 0($sp)


subi $a1, $a1, 1

subu $sp, $sp, 4      # Incrementa il puntatore dello stack di 4 byte (dimensione di una word)

sw $ra, 0($sp)

move $t0, $a0
move $a0, $a1
move $a1,$t0

jal funzione
lw $t1, 0($sp)
addu $sp, $sp, 4

lw $t0, 0($sp)
addu $sp, $sp, 4


mul $v0, $v0, $t0


jr $t1

caso_base:

li $v0, 1
jr $ra








