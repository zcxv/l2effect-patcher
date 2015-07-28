class 82 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect9
		AttachOn=AM_LA
		EffectClass=Class'LineageEffect.mo_majesty_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect10
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mo_majesty_ta'
	End Object
	Desc="마제스티" //Majesty
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect9',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect10',SpecificStage=0)
}