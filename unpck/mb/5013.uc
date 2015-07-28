class 5013 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect15
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mb_frintessa_ghost_drain'
	End Object
	Desc="유령흡수" //Ghost absorption
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect15',SpecificStage=0)
}