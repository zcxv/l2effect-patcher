class 5095 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect35
		AttachOn=AM_LH
		AttachBoneName="Bip01 Ponytail2Nub"
		EffectClass=Class'LineageEffect.e_u829_ca_a'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect44
		AttachOn=AM_LA
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_fatal_strike_ta'
	End Object
	Desc="안타라스부하근접공격" //Antharas melee load
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect35',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect44',SpecificStage=0)
}