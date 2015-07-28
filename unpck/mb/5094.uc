class 5094 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect29
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.at_shock_blast_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect45
		AttachOn=AM_LA
		EffectClass=Class'LineageEffect.e_u528_ta_bigsize_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect30
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_flame_strike_ta'
		bOnMultiTarget=True
	End Object
	Desc="안타라스부하자폭" //Antharas load suicide
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect29',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect45',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect30',SpecificStage=0)
}